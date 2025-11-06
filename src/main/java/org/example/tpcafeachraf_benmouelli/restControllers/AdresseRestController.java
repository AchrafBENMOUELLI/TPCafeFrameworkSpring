package org.example.tpcafeachraf_benmouelli.restControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.tpcafeachraf_benmouelli.dto.adresse.AdresseRequest;
import org.example.tpcafeachraf_benmouelli.dto.adresse.AdresseResponse;
import org.example.tpcafeachraf_benmouelli.entities.Adresse;
import org.example.tpcafeachraf_benmouelli.services.adresse.IAdresseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresse")
@AllArgsConstructor
@Tag(name = "Adresse", description = "Endpoints for managing adresses")
public class AdresseRestController {

    private final IAdresseService adresseService;

    /* @GetMapping
    @Operation(
            summary = "Retrieve all adresses",
            description = "Returns a list of all adresses registered in the system",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of adresses retrieved successfully"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    public List<Adresse> displayalladresses() {
        return adresseService.selectAllAdresses();
    } */
    ////////////////////////////////////////////////////////
    // 🔄 Nouvelle version avec DTO
    @GetMapping
    @Operation(
            summary = "Retrieve all adresses",
            description = "Returns a list of all adresses as DTOs",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of adresses retrieved successfully"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    public List<AdresseResponse> displayAllAdresses() {
        return adresseService.selectAllAdresses();
    }
    ////////////////////////////////////////////////////////

    /* @PostMapping
    public Adresse addadresse(@RequestBody Adresse adresse) {
        return adresseService.addAdresse(adresse);
    } */
    ////////////////////////////////////////////////////////
    // 🔄 Nouvelle version avec DTO
    @PostMapping
    @Operation(
            summary = "Add a new adresse",
            description = "Creates a new adresse using DTO",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Adresse added successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            }
    )
    public AdresseResponse addAdresse(@RequestBody AdresseRequest request) {
        return adresseService.addAdresse(request);
    }
    ////////////////////////////////////////////////////////

    /* @PostMapping("/addalladresses")
    public List<Adresse> addalladresses(@RequestBody List<Adresse> adresses) {
        return adresseService.saveAdresses(adresses);
    } */
    ////////////////////////////////////////////////////////
    // 🔄 Nouvelle version avec DTO
    @PostMapping("/addalladresses")
    @Operation(summary = "Add multiple adresses", description = "Saves a list of adresses using DTOs")
    public List<AdresseResponse> addAllAdresses(@RequestBody List<AdresseRequest> adressesRequest) {
        return adresseService.saveAdresses(adressesRequest);
    }
    ////////////////////////////////////////////////////////

    /* @GetMapping("/displayadressebyId/{id}")
    public Adresse displayadresseById(@PathVariable long id) {
        return adresseService.selectAdresseById(id);
    } */
    ////////////////////////////////////////////////////////
    // 🔄 Nouvelle version avec DTO
    @GetMapping("/displayadressebyId/{id}")
    @Operation(summary = "Find adresse by ID", description = "Returns adresse details by ID")
    public AdresseResponse displayAdresseById(@PathVariable long id) {
        return adresseService.selectAdresseById(id);
    }
    ////////////////////////////////////////////////////////

    @DeleteMapping("/deleteadresseById/{id}")
    @Operation(summary = "Delete adresse by ID")
    public void deleteAdresseById(@PathVariable long id) {
        adresseService.deleteAdresseById(id);
    }

    @DeleteMapping("/deletealladresses")
    @Operation(summary = "Delete all adresses")
    public void deleteAllAdresses() {
        adresseService.deleteAllAdresses();
    }

    @GetMapping("/countalladresses")
    @Operation(summary = "Count all adresses")
    public long countAllAdresses() {
        return adresseService.countingAdresses();
    }

    @GetMapping("/existadresse/{id}")
    @Operation(summary = "Check if adresse exists by ID")
    public boolean adresseExist(@PathVariable long id) {
        return adresseService.verifAdresse(id);
    }
}
