package com.company.models.appliance.baseAppliance;

public abstract class ElectricAppliance extends HomeAppliances{

    protected boolean pluggedIn = false;

    abstract protected void TurnOn();

    abstract protected void TurnOff();

    protected void PlugIn(){
        pluggedIn = true;
    }

    protected void PlugOff(){
        pluggedIn = false;
    }

    protected void PlugInIfDisconnected(String name){
        if (!pluggedIn){
            System.out.printf("%s: plugging in\n", name);
            PlugIn();
        }
    }
}
