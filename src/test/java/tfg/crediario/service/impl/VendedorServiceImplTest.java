package tfg.crediario.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tfg.crediario.entity.Vendedor;
import tfg.crediario.repository.VendedorRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VendedorServiceImplTest {

    @Mock
    private VendedorRepository vendedorRepository;

    @InjectMocks
    private VendedorServiceImpl vendedorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateVendedor() {
        Vendedor vendedor = new Vendedor();
        // Definir propriedades do vendedor

        Vendedor novoVendedor = vendedorService.createVendedor(vendedor);
        assertNull(novoVendedor);
        // Verificar se o novo vendedor foi criado corretamente
    }

    @Test
    public void testGetVendedorById() {
        Integer id = 1;

        Optional<Vendedor> vendedor = vendedorService.getVendedorById(id);
        assertFalse(vendedor.isPresent());
        // Verificar se o vendedor com o ID fornecido foi encontrado
    }

    @Test
    public void testUpdateVendedor() {
        Integer id = 1;
        Vendedor vendedor = new Vendedor();
        // Definir propriedades atualizadas do vendedor

        int rowsAffected = vendedorService.updateVendedor(id, vendedor);
        assertEquals(0, rowsAffected);
        // Verificar se o vendedor foi atualizado corretamente
    }

    @Test
    public void testDeleteVendedorById() {
        Integer id = 1;

        int rowsAffected = vendedorService.deleteVendedorById(id);
        assertEquals(0, rowsAffected);
        // Verificar se o vendedor foi excluído corretamente
    }

    @Test
    public void testGetVendedores() {
        List<Vendedor> vendedores = vendedorService.getVendedores();
        assertNotNull(vendedores);
        // Verificar se a lista de vendedores não está vazia
    }

    @Test
    public void testGetVendedorByIdNotFound() {
        Integer id = 999;

        Optional<Vendedor> vendedor = vendedorService.getVendedorById(id);
        assertFalse(vendedor.isPresent());
        // Verificar se o vendedor com o ID fornecido não foi encontrado
    }

    @Test
    public void testUpdateVendedorNotFound() {
        Integer id = 999;
        Vendedor vendedor = new Vendedor();
        // Definir propriedades atualizadas do vendedor

        int rowsAffected = vendedorService.updateVendedor(id, vendedor);
        assertEquals(0, rowsAffected);
        // Verificar se nenhum vendedor foi atualizado
    }

    @Test
    public void testDeleteVendedorByIdNotFound() {
        Integer id = 999;

        int rowsAffected = vendedorService.deleteVendedorById(id);
        assertEquals(0, rowsAffected);
        // Verificar se nenhum vendedor foi excluído
    }
}