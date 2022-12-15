package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

import static org.mockito.Mockito.*;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        ExpenseRepository repository = new ExpenseRepository(new MyDatabase());
        repository.loadExpenses();
        assertEquals(Collections.emptyList(), repository.getExpenses());
    }

    @Test
    void loadExpensesMock() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        when(mock.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository repository = new ExpenseRepository(mock);
        repository.loadExpenses();

        InOrder inOrder = inOrder(mock);
        inOrder.verify(mock).connect();
        inOrder.verify(mock).queryAll();
        inOrder.verify(mock).close();

        assertEquals(Collections.emptyList(), repository.getExpenses());
    }


    @Test
    void saveExpenses() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        when(mock.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository repository = new ExpenseRepository(mock);
        repository.loadExpenses();

        Expense exp = new Expense();

        repository.addExpense(exp);

        repository.saveExpenses();

        verify(mock).persist(any(Expense.class));

    }


    @Test
    void saveExpensesMultipleTimes() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        when(mock.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository repository = new ExpenseRepository(mock);
        repository.loadExpenses();

        Expense exp = new Expense();

        repository.addExpense(exp);
        repository.addExpense(new Expense());
        repository.addExpense(new Expense());
        repository.addExpense(new Expense());
        repository.addExpense(new Expense());

        repository.saveExpenses();

        verify(mock, times(5)).persist(any(Expense.class));

    }
}
