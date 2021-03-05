package com.company.models.appliance;

import com.company.models.appliance.baseAppliance.ElectricAppliance;

public class TeaPot extends ElectricAppliance {

    protected int power;
    protected int energyUsage;
    protected float volume;

    protected String name;

    public TeaPot(int power, int energyUsage, float volume, String name) {
        this.power = power;
        this.energyUsage = energyUsage;
        this.volume = volume;
        this.name = name;
    }

    public TeaPot(String name){
        this.power = 220;
        this.energyUsage = 150;
        this.volume = 3f;
        this.name = name;
    }

    public void BoilWater(){
        int boilingTime = (int) CalculateBoilingTimeMS();
        PrintAction("Boiling water");
        PrintAction("Time is: " + boilingTime/1000.f + " second");
        try {
            Thread.sleep(boilingTime);
        }
        catch (InterruptedException exception){
            PrintAction("Burned down");
        }
        finally {
            TurnOff();
        }
    }

    public void TurnOn(){
        PlugInIfDisconnected(name);
        PrintAction("Turned on");
        BoilWater();
    }

    public void TurnOff(){
        PrintAction("Turned off\n");
    }

    private float CalculateBoilingTimeMS(){
        return 100*volume*4200/power;
    }

    private void PrintAction(String action){
        System.out.printf("%s: %s\n", name, action);
    }
}
