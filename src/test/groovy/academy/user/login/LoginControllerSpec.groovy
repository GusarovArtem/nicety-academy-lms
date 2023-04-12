package academy.user.login

import grails.testing.web.controllers.ControllerUnitTest
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.client.RestTemplate

class LoginControllerSpec implements ControllerUnitTest<LoginController> {

    @Value('${auth.url}')
    private String AUTH_URL

    def jwtAuthProviderService
    def restTemplate

    // Set up the test data and dependencies
    void setup() {
        restTemplate = Mock(RestTemplate)
        controller.restTemplate = restTemplate
        controller.jwtAuthProviderService = Mock()
    }

    // Test for successful authentication
    void "test auth() with valid credentials"() {
        given:
        def credentials = [username: "test@example.com", password: "password"]
        def token = "valid-token"
        def headers = ['Content-Type' : 'application/json']

        restTemplate.postForObject(AUTH_URL, credentials, String.class, headers) >> token
        def authentication = new UsernamePasswordAuthenticationToken(token, credentials)
        controller.jwtAuthProviderService.authenticate(authentication) >> true

        when:
        controller.auth()

        then:
        1 * restTemplate.postForObject(AUTH_URL, credentials, String.class, headers)
        1 * controller.jwtAuthProviderService.authenticate(authentication)
        response.redirectedUrl == null
        flash.message == null
    }

    // Test for invalid credentials
    void "test auth() with invalid credentials"() {
        given:
        def credentials = [username: "test@example.com", password: "wrong-password"]
        def token = "invalid-token"
        def headers = ['Content-Type' : 'application/json']
        restTemplate.postForObject(AUTH_URL, credentials, String.class, headers) >> token
        def authentication = new UsernamePasswordAuthenticationToken(token, credentials)
        controller.jwtAuthProviderService.authenticate(authentication) >> { throw new Exception() }

        when:
        controller.auth()

        then:
        1 * restTemplate.postForObject(AUTH_URL, credentials, String.class, headers)
        1 * controller.jwtAuthProviderService.authenticate(authentication)
        response.redirectedUrl == null
        flash.message == "Invalid email or password"
    }
}
