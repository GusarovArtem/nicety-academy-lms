<ul class="nav navbar-nav">
    <academyMenu:branch title="Users" access="ROLE_ADMIN">
        <academyMenu:leaf controller="academyAdmin"
                          title="Admin"
                          access="ROLE_ADMIN"/>
        <academyMenu:leaf controller="academyTeacher"
                          title="Teacher"
                          access="ROLE_ADMIN"/>
    </academyMenu:branch>
    <academyMenu:leaf controller="academyCourse"
                      title="Course"
                      access="ROLE_ADMIN"/>
</ul>



