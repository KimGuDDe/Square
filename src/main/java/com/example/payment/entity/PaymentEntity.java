package com.example.payment.entity;

import com.example.classes.entity.ClassesEntity;
import com.example.user.entity.AcademiesEntity;
import com.example.user.entity.ParentsEntity;
import com.example.user.entity.StudentsEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="payments")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

//결제할 때만 사용하는 엔터티입니다.
//토스페이먼츠와 연계되는 부분
//장바구니 부분은 EnrollEntity에서 처리
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academy_id", nullable = false)
    private AcademiesEntity academy;

    //ClassEntity 만들면 연결할 생각
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private ClassesEntity classes;

    @Column(length = 100)
    private String duration_month;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ParentsEntity parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentsEntity student;
}
