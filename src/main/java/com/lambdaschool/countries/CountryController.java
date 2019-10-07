package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
//Beans - this POJO is managed by spring so it's called beans.
@RequestMapping("/data")
//no semicolon after these^
public class CountryController {
// localhost:2019/data/names/all

    @GetMapping(value = "/names/all",
            produces = {"application/json"})
    public ResponseEntity<?> getAllNames() {
        JavaCountriesProjectApplication.countryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(JavaCountriesProjectApplication.countryList.countryList, HttpStatus.OK);
    }
//    localhost:2019/data/names/start/{letter}
    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByLetter(@PathVariable char letter){
        ArrayList<Country> rtnCountries = JavaCountriesProjectApplication.countryList.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }
//    localhost:2019/data/population/size/{people}
//return the countries that have a population equal to or greater than the given population
    @GetMapping(value = "population/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByPopulation(@PathVariable int people){
        ArrayList<Country> rtnPopulation = JavaCountriesProjectApplication.countryList.findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(rtnPopulation, HttpStatus.OK);
    }
//    localhost:2019/data/population/min
//return the country with the smallest population
    @GetMapping(value = "population/min", produces = {"application/json"})
    public ResponseEntity<?> getSmallestPop(){
        JavaCountriesProjectApplication.countryList.countryList.sort((c1, c2) -> c1.getPopulation()-c2.getPopulation());
        return new ResponseEntity<>(JavaCountriesProjectApplication.countryList.countryList.get(0), HttpStatus.OK);
    }

//    localhost:2019/data/population/max
//return the country with the largest population
@GetMapping(value = "population/max", produces = {"application/json"})
    public ResponseEntity<?> getLargestPop() {
    JavaCountriesProjectApplication.countryList.countryList.sort((c1, c2) -> c2.getPopulation() - c1.getPopulation());
    return new ResponseEntity<>(JavaCountriesProjectApplication.countryList.countryList.get(0), HttpStatus.OK);
}
//    localhost:2019/data/names/size/{number}
//return the countries alphabetically that have a name equal to or longer than the given length

    @GetMapping(value = "names/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountryByNameLength(@PathVariable int number){
        ArrayList<Country> rtnCountriesByLength = JavaCountriesProjectApplication.countryList.findCountries(c-> c.getName().length() >= number);{
            return new ResponseEntity<>(rtnCountriesByLength, HttpStatus.OK);
        }
    }
}
