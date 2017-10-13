package com.redhat.insurance.messages;

import com.redhat.model.Car;
import com.redhat.model.Driver;
import com.redhat.model.Policy;

public class PolicyMessage {
	
	private Car car;
	
	private Driver driver;
	
	private Policy policy;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	
	public PolicyMessage() {
	}
}
