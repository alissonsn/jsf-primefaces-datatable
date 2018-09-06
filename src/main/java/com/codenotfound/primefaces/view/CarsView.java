package com.codenotfound.primefaces.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.codenotfound.primefaces.model.Car;
import com.codenotfound.primefaces.repository.CarRepository;

import lombok.Data;

@Named
@ViewScoped
@Data
public class CarsView implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private CarRepository carRepository;

  private Car car;
  
  private List<Car> cars;

  @PostConstruct
  public void init() {
	car = new Car();
    cars = carRepository.findAll();
  }
  
  public void cadastrar() {
	  carRepository.save(car);
  }

  public List<Car> getCars() {
    return cars;
  }
}
