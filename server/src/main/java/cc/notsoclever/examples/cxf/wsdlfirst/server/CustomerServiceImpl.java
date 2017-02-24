/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package cc.notsoclever.examples.cxf.wsdlfirst.server;

import cc.notsoclever.customerservice.Customer;
import cc.notsoclever.customerservice.CustomerService;
import cc.notsoclever.customerservice.CustomerType;
import cc.notsoclever.customerservice.NoSuchCustomer;
import cc.notsoclever.customerservice.NoSuchCustomerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static final transient Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private Map<String, Customer> customers = new HashMap<String, Customer>();

    public CustomerServiceImpl() {
        Customer customer = new Customer();
        String name = "Johns, Mary";
        customer.setName(name);
        customer.getAddress().add("Pine Street 200");
        Date bDate = new GregorianCalendar(2009, 1, 1).getTime();
        customer.setBirthDate(bDate);
        customer.setNumOrders(1);
        customer.setRevenue(10000);
        customer.setTest(new BigDecimal(1.5));
        customer.setType(CustomerType.BUSINESS);
        customers.put(name, customer);

        customer = new Customer();
        name = "Johns, Marvin";
        customer.setName(name);
        customer.getAddress().add("Oak Street 201");
        bDate = new GregorianCalendar(2010, 1, 1).getTime();
        customer.setBirthDate(bDate);
        customer.setNumOrders(1);
        customer.setRevenue(30000);
        customer.setTest(new BigDecimal(1.5));
        customer.setType(CustomerType.PRIVATE);
        customers.put(name, customer);

        customer = new Customer();
        name = "Jones";
        customer.setName(name);
        customer.getAddress().add("Oak Street 201");
        bDate = new GregorianCalendar(2010, 1, 1).getTime();
        customer.setBirthDate(bDate);
        customer.setNumOrders(1);
        customer.setRevenue(30000);
        customer.setTest(new BigDecimal(1.5));
        customer.setType(CustomerType.PRIVATE);
        customers.put(name, customer);
    }

    @Override
    public List<Customer> getCustomersByName(String name) throws NoSuchCustomerException {

        List<Customer> results = new ArrayList<Customer>();

        for (Customer customer : customers.values()) {
            if (customer.getName().startsWith(name)) {
                results.add(customer);
            }
        }

        if (results.size() == 0) {
            NoSuchCustomer noSuchCustomer = new NoSuchCustomer();
            noSuchCustomer.setCustomerName(name);
            throw new NoSuchCustomerException("Did not find any matching customer for name=" + name,
                    noSuchCustomer);
        }

        return results;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws NoSuchCustomerException {
        if (customers.containsKey(customer.getName())) {
            customers.put(customer.getName(), customer);
        } else {
            NoSuchCustomer noSuchCustomer = new NoSuchCustomer();
            noSuchCustomer.setCustomerName(customer.getName());
            throw new NoSuchCustomerException("Did not find any matching customer for name=" + customer.getName(),
                    noSuchCustomer);
        }
        return customer;
    }

}
