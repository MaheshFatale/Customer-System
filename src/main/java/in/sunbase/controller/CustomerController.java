package in.sunbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sunbase.entity.CustomerEntity;
import in.sunbase.entity.SearchCustomer;
import in.sunbase.repository.CustomerRepository;
import in.sunbase.service.CustomerService;
//import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private CustomerService service;

	@PostMapping("/searchCustomer")
	public String findCustomer(@ModelAttribute("cust") SearchCustomer searcust,Model model)
	{
		model.addAttribute("custs", service.getSearchCust(searcust));
		return "index";
	}
	
	
	@GetMapping("/CreateCustomer")
	public String loadCustomerForm(Model model)
	{
		model.addAttribute("cust", new CustomerEntity());
		return "CreateCustomer";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("cid")Integer cid,Model model)
	{
		repo.deleteById(cid);
		init(model);
		return "index";
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("cid") Integer cid,Model model)
	{
		model.addAttribute("cust", repo.findById(cid));
		return "CreateCustomer";
	}
	@PostMapping("/saveCustomer")
	public String handleSave(Model model, CustomerEntity cust)
	{	
		repo.save(cust);
		System.out.println(cust);
		init(model);
		return "index";
	}
	
	@GetMapping("/")
	public String loadForm(Model model)
	{
		init(model);	
		//model.addAttribute("findBy", service.getSearch());
		return "index";
	}


	private void init(Model model) {
		model.addAttribute("cust", new CustomerEntity());
		model.addAttribute("custs", repo.findAll());
	}
}
