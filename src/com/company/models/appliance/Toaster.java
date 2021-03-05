package com.company.models.appliance;

import com.company.models.appliance.baseAppliance.ElectricAppliance;

public class Toaster extends ElectricAppliance {

    private int cookingTime;
    private String name;

    public Toaster(String name){
        this.name = name;
        this.cookingTime = 4500;
    }

    public void TurnOn(){
        PrintAction("Turned on");
        MakeToasts();
    }

    public void TurnOff() {
        PrintAction("Toast has been cooked");
    }

    private void MakeToasts(){
        PrintAction("Making toast");
        PrintAction("Time is: " + cookingTime/1000.f + " seconds");
        try {
            Thread.sleep(cookingTime);
        }
        catch (InterruptedException exception){
            PrintAction("Toaster burned down");
        }
        finally {
            TurnOff();
        }
    }

    public void PrintAction(String action){
        System.out.printf("%s: %s\n", name, action);
    }
}
