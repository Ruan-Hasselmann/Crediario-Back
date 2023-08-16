package tfg.crediario.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tfg.crediario.entity.Cliente;
import tfg.crediario.entity.Endereco;
import tfg.crediario.entity.Pagamento;
import tfg.crediario.repository.ClienteRepository;
import tfg.crediario.service.EnderecoService;
import tfg.crediario.service.PagamentoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private EnderecoService enderecoService;

    @Mock
    private PagamentoService pagamentoService;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllClientes_Positive() {
        // Mock data
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente());
        when(clienteRepository.findAllByStatus()).thenReturn(clientes);

        // Test
        List<Cliente> result = clienteService.getAllClientes();

        // Verify
        assertFalse(result.isEmpty());
        assertEquals(clientes, result);
    }

    @Test
    public void testGetAllClientes_Negative() {
        // Mock data
        when(clienteRepository.findAllByStatus()).thenReturn(new ArrayList<>());

        // Test
        List<Cliente> result = clienteService.getAllClientes();

        // Verify
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetClienteById_Positive() {
        // Mock data
        int id = 1;
        Cliente cliente = new Cliente();
        cliente.setId(id);
        when(clienteRepository.findById(id)).thenReturn(Optional.of(cliente));

        // Test
        Optional<Cliente> result = clienteService.getClienteById(id);

        // Verify
        assertTrue(result.isPresent());
        assertEquals(cliente, result.get());
    }

    @Test
    public void testGetClienteById_Negative() {
        // Mock data
        int id = 1;
        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        // Test
        Optional<Cliente> result = clienteService.getClienteById(id);

        // Verify
        assertFalse(result.isPresent());
    }

    @Test
    public void testCreateCliente() {
        Cliente cliente = new Cliente();
        cliente.setEndereco(new Endereco());
        cliente.setPagamento(new Pagamento());

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.createCliente(cliente);

        assertTrue(result.getStatus());
        assertNotNull(result.getDataCadastro());

        verify(enderecoService, times(1)).createEndereco(cliente.getEndereco());
        verify(pagamentoService, times(1)).createPagamento(cliente.getPagamento());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testUpdateClientePositive() {
        Cliente cliente = new Cliente();
        Integer id = 1;
        cliente.setNome("João");
        cliente.setCpf("123456789");
        cliente.setRg(987654321);
        cliente.setTelefone("999999999");

        Integer result = clienteRepository.updateCliente(cliente.getNome(), cliente.getCpf(), cliente.getRg(), cliente.getTelefone(), id);

        assertEquals(Integer.valueOf(1), result);
    }

    @Test
    public void testUpdateClienteNegative() {
        Cliente cliente = new Cliente();
        Integer id = 999; // id inválido
        cliente.setNome("João");
        cliente.setCpf("123456789");
        cliente.setRg(987654321);
        cliente.setTelefone("999999999");

        Integer result = clienteRepository.updateCliente(cliente.getNome(), cliente.getCpf(), cliente.getRg(), cliente.getTelefone(), id);

        assertEquals(Integer.valueOf(0), result);
    }

    @Test
    public void testUpdateStatusCliente() {
        when(clienteRepository.updateStatus(true, 1)).thenReturn(1);

        Integer result = clienteService.updateStatusCliente(1, true);

        assertEquals(Integer.valueOf(0), result);

        verify(clienteRepository, times(1)).updateStatus(true, 1);
    }

}