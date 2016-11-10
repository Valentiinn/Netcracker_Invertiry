package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class AbstractDevice implements Device, Serializable {

    protected int in;
    protected final String type = getClass().getSimpleName();
    protected String manufacturer;
    protected String model;
    protected Date productionDate;

    static protected Logger LOGGER = Logger.getLogger(AbstractDevice.class.getName());

    @Override
    public int getIn() {
        return in;
    }

    @Override
    public void setIn(int in) {
        if (in <= 0) {
            IllegalArgumentException e = new IllegalArgumentException("in should not be less than 0");
            LOGGER.log(Level.SEVERE, "In  parameter  should not be less than  0");
            throw e;
        }
        this.in = in;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public void feelAllFields(Field[] fields) {
        feelAllFields(fields);
        setIn((Integer) fields[0].getValue());
        setManufacturer((String) fields[1].getValue());
        setModel((String) fields[2].getValue());
        setProductionDate((Date) fields[3].getValue());
    }

    @Override
    public Field[] getAllFields() {
        Field[] fields = new Field[5];
        System.arraycopy(getAllFields(), 0, fields, 0, 0);
        System.arraycopy(getAllFields(), 0, fields, 0, 1);
        System.arraycopy(getAllFields(), 0, fields, 0, 2);
        System.arraycopy(getAllFields(), 0, fields, 0, 3);
        Field in = new Field(Integer.class, getIn());
        Field manufacturer = new Field(Integer.class, getManufacturer());
        Field model = new Field(Integer.class, getModel());
        Field productionDate = new Field(Integer.class, getProductionDate());
        Field type = new Field(Integer.class, getType());
        fields[0] = in;
        fields[1] = manufacturer;
        fields[2] = model;
        fields[3] = productionDate;
        fields[4] = type;
        return fields;
    }


}
