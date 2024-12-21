/**
 * @ (#) ServletController.java      10/22/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controller;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.backend.dtos.ThuocDTO;
import vn.edu.iuh.fit.backend.entities.Loaithuoc;
import vn.edu.iuh.fit.backend.entities.Thuoc;
import vn.edu.iuh.fit.backend.services.QLThuocService;
import vn.edu.iuh.fit.frontend.models.ThuocModel;

import java.io.IOException;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/22/2024
 */
@WebServlet(name="ServletController", value = "/controller")
public class ServletController extends HttpServlet {
    @EJB
    private QLThuocService qlThuocService;

    @Inject
    private ThuocModel thuocModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);

        if(action.equalsIgnoreCase("medicines")){
//            List<ThuocDTO> medicines = qlThuocService.getAllDTO();
            List<ThuocDTO> medicines = thuocModel.getAllMedicine_API();
            session.setAttribute("medicines", medicines);
            req.getRequestDispatcher("ListMedicines.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("typeMedicines")){
            List<Loaithuoc> type = qlThuocService.getAllLoaiThuoc();
            session.setAttribute("type_medicine", type);
            req.getRequestDispatcher("TypeMedicine.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("insert")) {
            List<Loaithuoc> type = qlThuocService.getAllLoaiThuoc();
            session.setAttribute("type_medicine", type);
            req.setAttribute("action", action);
            req.getRequestDispatcher("formThuoc.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("insert")){
            Thuoc medicine = new Thuoc();
            medicine.setTenThuoc(req.getParameter("name"));
            medicine.setDonGia(Double.parseDouble(req.getParameter("price")));
            medicine.setNamSanXuat(Integer.parseInt(req.getParameter("namSX")));

            String loaiThuoc = req.getParameter("loai_thuoc");
            Loaithuoc loaithuoc = qlThuocService.getById(Long.parseLong(loaiThuoc));
            medicine.setLoaiThuoc(loaithuoc);
            thuocModel.createMedicine(medicine);
            resp.sendRedirect("controller?action=medicines");
        }
    }
}
