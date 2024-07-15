package in.sunbase.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import in.sunbase.binding.CustomerBinding;
import in.sunbase.entity.CustomerEntity;
import in.sunbase.entity.SearchCustomer;

public interface CustomerService {
	
	//public List<String> getSearch();
//	public List<CustomerEntity> getCustomer(int pageno);
	public List<CustomerEntity> getSearchCust(SearchCustomer searcust);
	
	
	public CustomerEntity saveCustomerEntity(CustomerEntity cust);
	
	public CustomerEntity updateCustomerEntity(Integer cid,CustomerEntity cust);
	public List<CustomerEntity> getAllCustomerEntity(Pageable pageable);
	public CustomerEntity getCustomerById(Integer cid);
	public void deleteCustomerEntity(Integer cid);

}
