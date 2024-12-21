package vn.edu.iuh.fit.frontend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.backend.entities.Dienthoai;

import java.util.List;

@Component
public class DienThoaiModel {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL_API = "http://localhost:8080/api/";

    public List<Dienthoai> getPhones() {
        return restTemplate.getForObject("http://localhost:8080/api/dt", List.class);
    }

    public Dienthoai getPhone(Long id) {
        return restTemplate.getForObject(URL_API + "dt/search/" + id, Dienthoai.class);
    }

    public void deletePhone(Long id) {
        restTemplate.delete(URL_API + "dt/delete/" + id);
    }

    public Dienthoai savePhone(Dienthoai dienthoai) {
       return restTemplate.postForObject(URL_API + "dt", dienthoai, Dienthoai.class);
    }

    public Dienthoai updatePhone(Dienthoai dienthoai) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Dienthoai> request = new HttpEntity<>(dienthoai, headers);

        return restTemplate.exchange(URL_API + "dt/update", HttpMethod.PUT, request, Dienthoai.class).getBody();
    }


}
