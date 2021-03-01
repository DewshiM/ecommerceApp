package com.example.RaysCourses.Security;

import com.google.common.collect.Sets;

import java.util.Set;


public enum ApplicationUserRole {
    STUDENT,//(Sets.newHashSet(COURSE_READ,STUDENT_READ,STUDENT_WRITE)),
    USER //(Sets.newHashSet(COURSE_WRITE,COURSE_READ,STUDENT_READ,STUDENT_WRITE));

   /* private final Set<ApplictionUserPermission> permissions;

    ApplicationUserRole(Set<ApplictionUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplictionUserPermission> getPermissions() {
        return permissions;
    }*/
}
