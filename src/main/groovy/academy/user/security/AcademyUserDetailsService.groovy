package academy.user.security

import academy.user.AcademyUser
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.userdetails.GormUserDetailsService
import grails.plugin.springsecurity.userdetails.NoStackUsernameNotFoundException
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException

class AcademyUserDetailsService extends GormUserDetailsService {

    static final List SYSTEM_USER_ROLE =
            [new SimpleGrantedAuthority(AcademyUserType.SYSTEM_USER.role)]

    @Override
    UserDetails loadUserByUsername(String username, boolean loadRoles)
            throws UsernameNotFoundException {
        loadUserByUsername(username)
    }

    @Override
    @Transactional(readOnly=true, noRollbackFor=[IllegalArgumentException, UsernameNotFoundException])
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AcademyUser user = AcademyUser.findByEmail(email)
        if (!user) throw new NoStackUsernameNotFoundException()

        def authorities = user.authorities().collect {
            new SimpleGrantedAuthority(it.authority)
        }

        new AcademyUserDetails(user.email, user.password, user.enabled,
                              !user.accountExpired, !user.passwordExpired,
                              !user.accountLocked, authorities ?: SYSTEM_USER_ROLE,
                               user.id, user.userType)
    }
}