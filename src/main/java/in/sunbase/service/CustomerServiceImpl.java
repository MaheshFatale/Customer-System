package in.sunbase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.sunbase.binding.CustomerBinding;
import in.sunbase.entity.CustomerEntity;
import in.sunbase.entity.SearchCustomer;
import in.sunbase.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository repo;
	
	
	
//	public List<String> getSearch() {
//		return Arrays.asList("First Name","City","Email","Phone"); 
//	}


//	public List<CustomerEntity> getCustomer(int pageno) {
//		//int pageno=2;
//		PageRequest p1=PageRequest.of(pageno-1, 10);
//		org.springframework.data.domain.Page<CustomerEntity> custmerlist=repo.findAll(p1);
//		List<CustomerEntity> listcust=custmerlist.getContent();
//		
//		return listcust;
//	}

	public List<CustomerEntity> getSearchCust(SearchCustomer searcust) {
		CustomerEntity c1=new CustomerEntity();
		if(!searcust.getFirst_Name().isEmpty() && !"".equals(searcust.getFirst_Name()))
		c1.setFirst_Name(searcust.getFirst_Name());
		
		if(!searcust.getCity().isEmpty() && !"".equals(searcust.getCity()))
		c1.setCity(searcust.getCity());
		
		if(!searcust.getEmail().isEmpty() && !"".equals(searcust.getEmail()))
		c1.setEmail(searcust.getEmail());
		
		if(!searcust.getPhoneNo().isEmpty() && !"".equals(searcust.getPhoneNo()))
		c1.setPhoneNo(searcust.getPhoneNo());
		
		return repo.findAll(Example.of(c1));
	}



	
	
	
	
	@Override
	public CustomerEntity saveCustomerEntity(CustomerEntity cust) {
		return repo.save(cust);
	}



	@Override
	public CustomerEntity updateCustomerEntity(Integer cid, CustomerEntity cust) {

		
			
		//		Optional<CustomerEntity> c1=repo.findById(cid);
//		c1.setFirst_Name(cust.getFirst_Name());
//		c1.setLast_Name(cust.getLast_Name());
//		c1.setStreet(cust.getStreet());
//		c1.setAddress(cust.getAddress());
//		c1.setCity(cust.getCity());
//		c1.setState(cust.getState());
//		c1.setEmail(cust.getEmail());
//		c1.setPhoneNo(cust.getPhoneNo());
		return cust;
	}



	@Override
	public List<CustomerEntity> getAllCustomerEntity(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public CustomerEntity getCustomerById(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteCustomerEntity(Integer cid) {
		// TODO Auto-generated method stub
		
	}

}
