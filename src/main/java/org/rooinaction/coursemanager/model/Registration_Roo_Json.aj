// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.rooinaction.coursemanager.model.Registration;

privileged aspect Registration_Roo_Json {
    
    public String Registration.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String Registration.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static Registration Registration.fromJsonToRegistration(String json) {
        return new JSONDeserializer<Registration>()
        .use(null, Registration.class).deserialize(json);
    }
    
    public static String Registration.toJsonArray(Collection<Registration> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String Registration.toJsonArray(Collection<Registration> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Registration> Registration.fromJsonArrayToRegistrations(String json) {
        return new JSONDeserializer<List<Registration>>()
        .use("values", Registration.class).deserialize(json);
    }
    
}