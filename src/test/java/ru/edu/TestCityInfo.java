package ru.edu;

import ru.edu.dao.CityRepository;
import ru.edu.service.CityInfo;
import ru.edu.service.CityService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestCityInfo {
    public static void main(String[] args) throws SQLException {

        CityInfo city = new CityInfo();
        city.setName("Апшеронск");
        city.setDescription("Краснодарский край");
        city.setClimate("климат умеренный");
        city.setLatitude(0.123456);
        city.setLongitude(0.765432);
        city.createId();
        city.setPopulation(150000);

        // id= -862289349
        System.out.println(city);
        System.out.println("************************************************************************");

        String url = "jdbc:sqlite:db/simple_database.db";
        Connection connect = DriverManager.getConnection(url);

        CityRepository repository = new CityRepository();
        repository.setConnection(connect);

        CityService service = new CityService();
        service.setRepository(repository);

        CityInfo cityInfo = service.create(city);
        System.out.println(cityInfo);

//        CityInfo info = service.delete("-862289349");
//        System.out.println(info);
    }
}
