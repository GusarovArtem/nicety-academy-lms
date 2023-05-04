<ul class="nav navbar-nav">
    <menu:branch title="Users" access="ROLE_ADMIN">
        <menu:leaf controller="academyAdmin"
                          title="Admin"
                          access="ROLE_ADMIN"/>
        <menu:leaf controller="academyTeacher"
                          title="Teacher"
                          access="ROLE_ADMIN"/>
        <menu:branch title="Management" access="ROLE_ADMIN">
            <menu:leaf controller="academyHrManager"
                              title="HR Manager"
                              access="ROLE_ADMIN"/>
            <menu:leaf controller="academyStudentManager"
                              title="Student Manager"
                              access="ROLE_ADMIN, ROLE_HR_MANAGER"/>
        </menu:branch>
    </menu:branch>
    <menu:leaf controller="academyCourse"
                      title="Course"
                      access="ROLE_ADMIN"/>
    <menu:leaf controller="academyCourseType"
                      title="Course Type"
                      access="ROLE_ADMIN"/>
    <menu:leaf controller="academyGroup"
                      title="Group"
                      access="ROLE_ADMIN"/>
</ul>



