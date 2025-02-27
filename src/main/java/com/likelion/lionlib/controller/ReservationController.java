package com.likelion.lionlib.controller;


import com.likelion.lionlib.dto.request.ReservationRequest;
import com.likelion.lionlib.dto.response.ReservationCountResponse;
import com.likelion.lionlib.dto.response.ReservationResponse;
import com.likelion.lionlib.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReservationController {

    private final ReservationService service;

    @PostMapping("/reservations")
    public ResponseEntity<ReservationResponse> addReservation(@RequestBody ReservationRequest request) {
        return ResponseEntity.ok(service.addReservation(request));
    }

    @GetMapping("/reservations/{reservationId}")
    public ResponseEntity<ReservationResponse> getReservation(@PathVariable(name = "reservationId") Long reservationId) {
        return ResponseEntity.ok(service.getReservation(reservationId));
    }

    @DeleteMapping("/reservations/{reservationId}")
    public void deleteReservation(@PathVariable(name = "reservationId") Long reservationId) {
        service.deleteReservation(reservationId);
    }

    @GetMapping("members/{memberId}/reservations")
    public ResponseEntity<List<ReservationResponse>> getMemberReservations(@PathVariable(name = "memberId") Long memberId) {
        return ResponseEntity.ok(service.getReservationsByMember(memberId));
    }

    @GetMapping("books/{bookId}/reservations")
    public ResponseEntity<ReservationCountResponse> getReservationCounts(@PathVariable(name = "bookId") Long bookId) {
        return ResponseEntity.ok(service.getReservationCount(bookId));
    }
}
