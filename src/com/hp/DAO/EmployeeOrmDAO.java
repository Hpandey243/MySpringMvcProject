package com.hp.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hp.Entity.Employee;
import com.hp.bean.EmployeeBean;


@Repository
public class EmployeeOrmDAO {
	
private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void insert (EmployeeBean emp) {
    	Session session = sessionFactory.openSession();
    	Transaction tran=session.beginTransaction();
    	
    	Employee empo=new Employee();
    	BeanUtils.copyProperties(emp, empo);
    	session.save(empo);
    
    	tran.commit();
    	session.close();
    	
    }
    
    public List<EmployeeBean> getAllEmp(){
     Session session = sessionFactory.openSession();
     String s="select e from Employee e ";
     
    @SuppressWarnings("rawtypes")
	Query query=session.createQuery(s);
     EmployeeBean ebean=null;
     List<EmployeeBean>empdbList=new ArrayList<>();
     
     @SuppressWarnings("unchecked")
	List<Employee>emporm=query.list();
     
     for (Employee ee: emporm) {
    	 ebean=new EmployeeBean();
    	 BeanUtils.copyProperties(ee, ebean);
    	 empdbList.add(ebean);
    	 
     }
     
      return empdbList;
    }

    public EmployeeBean searchEmployee (Integer empId) {
    	Session session = sessionFactory.openSession();
    	Employee empo=session.get(Employee.class, empId);
    	EmployeeBean ee=new EmployeeBean();
    	BeanUtils.copyProperties(empo, ee);
    	return ee;
    	
    }
    public void delete (Integer empId) {
    	Session session = sessionFactory.openSession();
    	Transaction tran=session.beginTransaction();
    	Employee empo=session.get(Employee.class, empId);
    	session.delete(empo);
    
    	tran.commit();
    	session.close();
    	
    }
}
