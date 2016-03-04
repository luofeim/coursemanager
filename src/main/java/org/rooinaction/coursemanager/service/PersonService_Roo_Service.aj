// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.service;

import java.util.List;
import org.rooinaction.coursemanager.model.Person;
import org.rooinaction.coursemanager.service.PersonService;

privileged aspect PersonService_Roo_Service {
    
    public abstract long PersonService.countAllPeople();    
    public abstract void PersonService.deletePerson(Person person);    
    public abstract Person PersonService.findPerson(Long id);    
    public abstract List<Person> PersonService.findAllPeople();    
    public abstract List<Person> PersonService.findPersonEntries(int firstResult, int maxResults);    
    public abstract void PersonService.savePerson(Person person);    
    public abstract Person PersonService.updatePerson(Person person);    
}
