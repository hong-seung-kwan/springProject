//package com.example.demo.orderProduct;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//@RestController
//public class OrderProductDateController {
//
//	@Autowired
//	OrderProductService service;
//	
//	@GetMapping("/orderInfo")
//	public List<OrderProductDTO> orderInfoByDate(@RequestParam(value="startDate",required = false) String startDate,@RequestParam(value="endDate",required = false) String endDate) {
//		
//		List<OrderProductDTO> dto = service.getOrderProductByDate(LocalDate.parse(startDate), LocalDate.parse(endDate));
//				
//		return dto;		
//	}
//	
//	
//}
