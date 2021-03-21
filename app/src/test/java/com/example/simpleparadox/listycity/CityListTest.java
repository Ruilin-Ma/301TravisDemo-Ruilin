package com.example.simpleparadox.listycity;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    void testAddExcepetion() {
        CityList cityList = mockCityList();

        City city = new City("Calgary", "Alberta");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0,mockCity().compareTo(cityList.getCities().get(0)));//error
        City city = new City("HaiKou", "HaiNan Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

    }
    
    @Test
    void testDeleteCity(){
        CityList cityList = mockCityList();
        City city = new City("London", "Ontario");
        cityList.add(city);
        assertEquals(2, cityList.countCities());//error
        cityList.delete(mockCity());
        assertEquals(1,cityList.countCities());    
    }
}
