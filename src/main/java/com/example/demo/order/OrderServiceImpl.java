package com.example.demo.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cart.CartRepository;
import com.example.demo.orderProduct.OrderProduct;
import com.example.demo.orderProduct.OrderProductDTO;
import com.example.demo.orderProduct.OrderProductRepository;
import com.example.demo.orderProduct.OrderProductService;
import com.example.demo.product.Product;
import com.example.demo.product.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderProductRepository orderProductRepository;
	@Autowired
	OrderProductService orderProductService;

	@Override
	public List<OrderDTO> getOrderByUserId(String userId) {

		List<Order> list = repository.findByUserUserId(userId);

		List<OrderDTO> dtolist = new ArrayList<>();

		for (Order order : list) {
			OrderDTO dto = entityToDto(order);

			List<OrderProductDTO> productDTO = orderProductService.getOrderProductByOrderNo(order.getOrderNo());
			dto.setOrderProductDTO(productDTO);
			dtolist.add(dto);
		}

		return dtolist;
	}

	@Override
	public void register(OrderDTO dto, List<OrderProductDTO> productDTOList) {

		Order order = dtoToEntity(dto);
		repository.save(order);

		for (OrderProductDTO orderProductDTO : dto.getOrderProductDTO()) {

			Product product = productRepository.findById(orderProductDTO.getProductId()).orElseThrow();
			OrderProduct orderProduct = orderProductService.dtoToEntity(orderProductDTO);

			orderProduct.setOrder(order);
			orderProduct.setProduct(product);

			orderProductRepository.save(orderProduct);
		}

	}

	@Transactional
	@Override
	public void remove(int orderNo) {

		orderProductRepository.deleteByOrderOrderNo(orderNo);

		repository.deleteById(orderNo);

	}
	@Transactional
	@Override
	public List<OrderDTO> getOrderByStatus(String userId, String status) {
		List<Order> list;
		
		if("전체".equals(status)) {
			list = repository.findByUserUserId(userId);
		}else {
			list = repository.findByUserAndStatus(userId, status);
		}
		List<OrderDTO> dtolist = new ArrayList<>();
		
		for(Order order : list) {
			OrderDTO dto = entityToDto(order);
			
			
			List<OrderProductDTO> productDTO = orderProductService.getOrderProductByOrderNo(order.getOrderNo());
			dto.setOrderProductDTO(productDTO);
			dtolist.add(dto);
		}
		
		return dtolist;
	}
	
	@Transactional
	@Override
	public List<OrderDTO> getOrderByDate(String userId, LocalDate startDate, LocalDate endDate) {
		
		List<Order> list = repository.findByOrderOrderDate(userId, startDate, endDate);
		List<OrderDTO> dtolist = new ArrayList<>();
		
		for(Order order : list) {
			OrderDTO dto = entityToDto(order);
			
			List<OrderProductDTO> productDTO = orderProductService.getOrderProductByOrderNo(order.getOrderNo());
			dto.setOrderProductDTO(productDTO);
			dtolist.add(dto);
		}
				
		return dtolist;
	}

}
