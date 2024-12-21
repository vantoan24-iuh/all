/**
 * @ (#) PhoneModels.java      12/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.backend.entities.Phone;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/19/2024
 */
@Component
public class PhoneModels {
    @Autowired
    private RestTemplate restTemplate;

    private final String URL_API = "http://localhost:8080/api/";

    public List<Phone> getPhones() {
        return restTemplate.getForObject("http://localhost:8080/api/phones", List.class);
    }

    public Phone getPhone(Long id) {
        return restTemplate.getForObject(URL_API + "phones/" + id, Phone.class);
    }

    public Phone savePhone(Phone phone) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Phone> request = new HttpEntity<>(phone, headers);

        ResponseEntity<Phone> res = restTemplate.exchange(
                URL_API + "phones",
                org.springframework.http.HttpMethod.POST,
                request,
                Phone.class
        );
        return res.getBody();
    }

    public void deletePhone(Long id) {
        restTemplate.delete(URL_API + "phones/delete/" + id);
    }



}
