package academy.jwt

class JwtResponse implements Serializable {

    private final String jwt

    JwtResponse(String jwt) {
        this.jwt = jwt
    }

    String getToken() {
        return this.jwt
    }
}

