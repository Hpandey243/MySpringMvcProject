package com.hp.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.hp.Entity.Address;
import com.hp.Entity.Employee;
import com.hp.Entity.Traveller;
import com.hp.bean.AddressBean;
import com.hp.bean.EmployeeBean;
import com.hp.bean.TravellerBean;

@Repository
public class JpaDao  {
	
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	@Qualifier("entityManagerFactory")
	public void setEntitymanager(EntityManagerFactory entitymanager) {
		this.entityManagerFactory = entitymanager;
	}


	public void insertEmp(EmployeeBean emp) {
		EntityManager entityManager=this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee empo=new Employee();
		BeanUtils.copyProperties(emp, empo);
		List<Address> addList=new ArrayList<>();
		Address address =null;
		for (AddressBean add: emp.getAddress()) {
			address =new Address();
			BeanUtils.copyProperties(add, address);
			address.setEmployee(empo);
			addList.add(address);
		}
		empo.setAdd(addList);
		entityManager.persist(empo);
		entityManager.getTransaction().commit();	
		
	}
	@SuppressWarnings("unchecked")
	public List<EmployeeBean> fetchEmployee(){
		EntityManager entityManager=this.entityManagerFactory.createEntityManager();
		List<Employee>lemp=(List<Employee>) entityManager.createQuery("select e from Employee e").getResultList();
		
	     List<EmployeeBean>employeList=new ArrayList<>();
	     List<AddressBean> addressList=new ArrayList<>();
	     EmployeeBean ebean=null;
		 AddressBean addressBean=null;
		   
		     for (Employee ee: lemp) {
		    	 ebean=new EmployeeBean();
		    	 BeanUtils.copyProperties(ee, ebean);
		    	 addressBean=new AddressBean();
		    	 for(Address add: ee.getAdd()) {
		    		BeanUtils.copyProperties(add, addressBean); 
		    		addressList.add(addressBean);
		    		 
		    	 }
		    	 ebean.setAddress(addressList);
		    	 employeList.add(ebean);
		    	 
		     }
		     
		return employeList;
		
	}

	
	
/*Traveller DAO	*/
	
	public void insertTraveller(TravellerBean travellerBean) {
		EntityManager entityManager=this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();		
		Traveller traveller =new Traveller();
		Address address=new Address();
		BeanUtils.copyProperties(travellerBean, traveller);
		BeanUtils.copyProperties(travellerBean.getAddress(), address);
		traveller.setAddress(address);
		entityManager.persist(traveller);
		entityManager.getTransaction().commit();	
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<TravellerBean> fetchAllTravellers() {
		EntityManager entityManager=this.entityManagerFactory.createEntityManager();
		List<Traveller>travList=(List<Traveller>) entityManager.createQuery("select t from Traveller t").getResultList();
		List<TravellerBean> travelerBeanList=new ArrayList<>();
		TravellerBean travellerBean=null;
		AddressBean addressBean=null;
		for(Traveller t:travList) {
			travellerBean=new TravellerBean();
		
			BeanUtils.copyProperties(t,travellerBean);
			 addressBean=new AddressBean();
	    	 BeanUtils.copyProperties(t.getAddress(),addressBean);
	    	 travellerBean.setAddress(addressBean);
	    	 
			travelerBeanList.add(travellerBean);
		}
		return 	travelerBeanList;
		
}


	@SuppressWarnings("unchecked")
	public List<TravellerBean> searchTravellers(Integer travelId) {
		EntityManager entityManager=this.entityManagerFactory.createEntityManager();
		Query hql =  entityManager.createQuery("select t from Traveller t where t.tId=:travelId ");
		List<Traveller>travList=(List<Traveller>)hql.setParameter("travelId", travelId).getResultList();
		
		List<TravellerBean> travelerBeanList=new ArrayList<>();
		TravellerBean travellerBean=null;
		AddressBean addressBean=null;
		for(Traveller t:travList) {
			travellerBean=new TravellerBean();		
			BeanUtils.copyProperties(t,travellerBean);
			 addressBean=new AddressBean();
	    	 BeanUtils.copyProperties(t.getAddress(),addressBean);
	    	 travellerBean.setAddress(addressBean);
			travelerBeanList.add(travellerBean);
		}
		return 	travelerBeanList;
		
	}

	public String saveAddress(Address address) {
		EntityManager entityManager=this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employee =  entityManager.find(Employee.class,address.getEmployee().getEmpId());
		address.setEmployee(employee);
		entityManager.persist(address);
		entityManager.getTransaction().commit();
		return "Address saved for employee " ;		
	}
	
}
