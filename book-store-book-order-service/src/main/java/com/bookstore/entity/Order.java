package com.bookstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Order date is mandatory")
    private LocalDate orderDate;

    @NotBlank(message = "Customer name is mandatory")
    private String customerName;

    @NotBlank(message = "Customer email is mandatory")
    private String customerEmail;

    @ElementCollection
    @CollectionTable(name = "order_books", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "book_id")
    private List<Long> bookIds;

    @NotNull(message = "Total amount is mandatory")
    private Double totalAmount;
}