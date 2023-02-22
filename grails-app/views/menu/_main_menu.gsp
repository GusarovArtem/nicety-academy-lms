<ul class="nav navbar-nav">
    <academyMenu:branch title="Users" access="ROLE_ADMIN">
        <academyMenu:leaf controller="academyAdmin"
                          title="Admin"
                          access="ROLE_ADMIN"/>
        <academyMenu:leaf controller="academyTeacher"
                          title="Teacher"
                          access="ROLE_ADMIN"/>
        <academyMenu:branch title="Management" access="ROLE_ADMIN">
            <academyMenu:leaf controller="academyHrManager"
                              title="HR Manager"
                              access="ROLE_ADMIN"/>
            <academyMenu:leaf controller="academyStudentManager"
                              title="Student Manager"
                              access="ROLE_ADMIN, ROLE_HR_MANAGER"/>
        </academyMenu:branch>
    </academyMenu:branch>
    <academyMenu:leaf controller="academyCourse"
                      title="Course"
                      access="ROLE_ADMIN"/>
    <academyMenu:leaf controller="academyGroup"
                      title="Group"
                      access="ROLE_ADMIN"/>
</ul>



