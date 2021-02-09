package com.vetApplication.program.security;

public enum ApplicationUserPermission {

    EMPLEADO_READ("empleado:read"),
    EMPLEADO_WRITE("empleado:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    ApplicationUserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }


}
