package com.finance.transaction.controller;

import java.util.List;

import com.finance.transaction.dto.CustomResponse;
import com.finance.transaction.dto.ExpenditureSummaryDTO;
import com.finance.transaction.dto.IncomeDepositDTO;
import com.finance.transaction.model.Transaction;
import com.finance.transaction.service.ExpenditureService;
import com.finance.transaction.service.IncomeDepositService;
import com.finance.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/test/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ExpenditureService expenditureService;


    // Endpoint to add a transaction
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse<Transaction>> addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }
    @PostMapping(value="multiple",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTransactions(@RequestBody List<Transaction> transactions) {
        transactionService.addTransactions(transactions);
        return ResponseEntity.ok("added");
    }

    // Endpoint to get all transactions of a user by userId
    @GetMapping("/{userId}")
    public ResponseEntity<List<Transaction>> getAllTransactionsByUserId(@PathVariable Long userId) {
        List<Transaction> transactions = transactionService.getTransactions(userId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/expenditure-summary/{userId}")
    public ExpenditureSummaryDTO getExpenditureSummary(@PathVariable Long userId) {
        return expenditureService.getExpenditureSummary(userId);
    }

    @Autowired
    private IncomeDepositService incomeDepositService;

    @GetMapping("/weekly-summary")
    public List<IncomeDepositDTO> getWeeklySummary(@RequestParam Long userId) {
        return incomeDepositService.getWeeklyDepositsAndWithdrawals(userId);
    }

    @GetMapping("/monthly-summary")
    public List<IncomeDepositDTO> getMonthlySummary(@RequestParam Long userId) {
        return incomeDepositService.getMonthlyDepositsAndWithdrawals(userId);
    }

    @GetMapping("/yearly-summary")
    public List<IncomeDepositDTO> getYearlySummary(@RequestParam Long userId) {
        return incomeDepositService.getYearlyDepositsAndWithdrawals(userId);
    }

}
