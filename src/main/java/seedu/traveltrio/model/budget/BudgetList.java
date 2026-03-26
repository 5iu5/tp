package seedu.traveltrio.model.budget;

import java.util.Map;
import java.util.HashMap;

import seedu.traveltrio.TravelTrioException;
import seedu.traveltrio.model.activity.Activity;

public class BudgetList {
    private final Map<Activity, Budget> budgets;
    private double totalTripBudget;
    private double totalTripExpense;

    public BudgetList() {
        this.budgets = new HashMap<>();
        this.totalTripBudget = 0;
    }

    public double getTotalRemainingTripBudget() {
        double totalRemaining = 0;
        for (Budget b : budgets.values()) {
            totalRemaining += b.getRemainingBudget();
        }
        return totalRemaining;
    }

    public void addBudget(Activity activity, Budget budget) {
        budgets.put(activity, budget);
        totalTripBudget += budget.getTotalBudget();
    }

    public void removeBudget(Activity activity) {
        totalTripBudget -= budgets.get(activity).getTotalBudget();
        budgets.remove(activity);
    }

    public Budget getBudget(Activity activity) {
        return budgets.get(activity);
    }

    public double getTotalTripBudget() {
        return totalTripBudget;
    }

    public Map<Activity, Budget> getBudgets() {
        return budgets;
    }

    public void setExpense(Activity activity, double newExpense) throws TravelTrioException {
        assert activity != null : "Activity should not be null";
        Budget budget = budgets.get(activity);
        if (budget == null) {
            throw new TravelTrioException("You must add a budget for this activity first.");
        }

        double oldExpense = budget.getActualExpense();
        budget.setActualExpense(newExpense);
        totalTripExpense = totalTripExpense - oldExpense + newExpense;
    }

    public double getTotalTripExpense() {
        return totalTripExpense;
    }

    public boolean isEmpty() {
        return budgets.isEmpty();
    }
}
