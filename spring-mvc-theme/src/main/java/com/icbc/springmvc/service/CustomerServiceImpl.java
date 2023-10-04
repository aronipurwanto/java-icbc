package com.icbc.springmvc.service;

import com.icbc.springmvc.model.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private List<CustomerModel> customers;

    public CustomerServiceImpl() {
        this.customers = new ArrayList<>();
        CustomerModel customer1 = new CustomerModel(1,
                123444550L,
                "Hermawan",
                "hermawan@gmail.com",
                "Cengkareng",
                "628134445667");
        this.customers.add(customer1);

        CustomerModel customer2 = new CustomerModel(2,
                123444552L,
                "Monica",
                "monica@gmail.com",
                "Kalideres",
                "628134445997");
        this.customers.add(customer2);
    }

    @Override
    public List<CustomerModel> gets() {
        return this.customers;
    }

    @Override
    public Optional<CustomerModel> getById(int id) {
        Optional<CustomerModel> result = this.customers.stream()
                .filter(x -> x.getId() == id)
                .findFirst();

        return result;
    }

    @Override
    public void save(CustomerModel request) {
        // get last id
        int lastId = this.customers.stream()
                .mapToInt(CustomerModel::getId)
                .max()
                .orElse(0);
        // new id
        request.setId(lastId+1);
        this.customers.add(request);
    }

    @Override
    public void update(CustomerModel request, int id) {
        int index = 0;
        CustomerModel oldData = null;
        for (int i=0; i < this.customers.size(); i++){
            CustomerModel data = this.customers.get(i);
            if(data.getId() == id){
                index = i;
                oldData = data;
                break;
            }
        }
        // if null or not found
        if(oldData == null){
            return;
        }

        oldData.setAccountNo(request.getAccountNo());
        oldData.setName(request.getName());
        oldData.setEmail(request.getEmail());
        oldData.setPhoneNumber(request.getPhoneNumber());
        oldData.setAddress(request.getAddress());

        // replace customer list with new data
        this.customers.set(index, oldData);
    }

    @Override
    public void delete(int id) {
        int index = 0;
        CustomerModel oldData = null;
        for (int i=0; i < this.customers.size(); i++){
            CustomerModel data = this.customers.get(i);
            if(data.getId() == id){
                index = i;
                oldData = data;
                break;
            }
        }
        if(oldData == null){
            return;
        }

        this.customers.remove(index);
    }
}
