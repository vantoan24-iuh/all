/**
 * @ (#) ThuocModel.java      10/22/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.dtos.ThuocDTO;
import vn.edu.iuh.fit.backend.entities.Thuoc;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/22/2024
 */
public class ThuocModel {
    private final String URL = "http://localhost:8080/QLThuoc-1.0-SNAPSHOT/api/medicine";

    /**
     * Create a new medicine
     * @param thuoc
     */
    public void createMedicine(Thuoc thuoc) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(URL);

            Response response = target.request().post(Entity.json(thuoc));
            if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                System.out.println("Medicine added successfully");
            } else {
                System.out.println("Failed to add medicine");
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all medicines from API
     * @return List of ThuocDTO
     */
    public List<ThuocDTO> getAllMedicine_API() {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(URL);

            // Get JSON from API
            String jsonList = target.request(MediaType.APPLICATION_JSON)
                            .get()
                            .readEntity(String.class);

            // Convert JSON to List of ThuocDTO by using ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            //C1
            // readValue() method is used to convert JSON to List
            // constructCollectionType() method is used to create a collection type
            //List<ThuocDTO> list = mapper.readValue(jsonList, mapper.getTypeFactory().constructCollectionType(List.class, ThuocDTO.class));

            //C2
            // TypeReference chỉ rõ kiểu dữ liệu cần chuyển đổi từ JSON sang Java
            List<ThuocDTO> list = mapper.readValue(jsonList, new TypeReference<List<ThuocDTO>>(){});
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
