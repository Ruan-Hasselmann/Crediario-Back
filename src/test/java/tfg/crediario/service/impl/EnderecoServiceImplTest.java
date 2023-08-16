package tfg.crediario.service.impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tfg.crediario.entity.Endereco;
import tfg.crediario.repository.EnderecoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class EnderecoServiceImplTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private EnderecoServiceImpl enderecoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetEnderecoById() {
        // Mocking the repository response
        Endereco endereco = new Endereco();
        when(enderecoRepository.findById(1)).thenReturn(Optional.of(endereco));

        // Calling the service method
        Optional<Endereco> result = enderecoService.getEnderecoById(1);

        // Verifying the result
        Assertions.assertEquals(Optional.of(endereco), result);
    }

    @Test
    public void testGetAllEnderecos() {
        // Mocking the repository response
        List<Endereco> enderecos = new ArrayList<>();
        when(enderecoRepository.findAll()).thenReturn(enderecos);

        // Calling the service method
        List<Endereco> result = enderecoService.getAllEnderecos();

        // Verifying the result
        Assertions.assertEquals(enderecos, result);
    }

    @Test
    public void testCreateEndereco() {
        // Mocking the repository response
        Endereco endereco = new Endereco();
        when(enderecoRepository.save(endereco)).thenReturn(endereco);

        // Calling the service method
        Endereco result = enderecoService.createEndereco(endereco);

        // Verifying the result
        Assertions.assertEquals(endereco, result);
    }

    @Test
    public void testUpdateEndereco() {
        // Mocking the repository response
        Endereco endereco = new Endereco();
        when(enderecoRepository.updateEndereco(any(), any(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        // Calling the service method
        Integer result = enderecoService.updateEndereco(1, endereco);

        // Verifying the result
        Assertions.assertEquals(endereco, result);
    }

    @Test
    public void testDeleteEndereco() {
        // Mocking the repository response
        when(enderecoRepository.deleteEnderecoById(1)).thenReturn(1);

        // Calling the service method
        Integer result = enderecoService.deleteEndereco(1);

        // Verifying the result
        Assertions.assertEquals(1, result);
    }
}