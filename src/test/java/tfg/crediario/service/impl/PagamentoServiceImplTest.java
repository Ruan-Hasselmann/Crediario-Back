package tfg.crediario.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tfg.crediario.entity.Pagamento;
import tfg.crediario.repository.PagamentoRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PagamentoServiceImplTest {

    @Mock
    private PagamentoRepository pagamentoRepository;

    @InjectMocks
    private PagamentoServiceImpl pagamentoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllPagamentos() {
        // Arrange
        List<Pagamento> expectedPagamentos = Arrays.asList(
                new Pagamento(1, "01/01/2022", "01/01/2022", 100.0, "Pix", 50.0, "Mensal", 50.0, 50.0),
                new Pagamento(2, "02/01/2022", "02/01/2022", 200.0, "Pix", 100.0, "Mensal", 100.0, 100.0)
        );
        when(pagamentoRepository.findAllPagamentos()).thenReturn(expectedPagamentos);

        // Act
        List<Pagamento> actualPagamentos = pagamentoService.getAllPagamentos();

        // Assert
        assertEquals(expectedPagamentos, actualPagamentos);
    }

    @Test
    void testGetPagamentoById() {
        // Arrange
        Pagamento expectedPagamento = new Pagamento(1, "01/01/2022", "01/01/2022", 100.0, "Pix", 50.0, "Mensal", 50.0, 50.0);
        when(pagamentoRepository.findById(1)).thenReturn(Optional.of(expectedPagamento));

        // Act
        Optional<Pagamento> actualPagamento = pagamentoService.getPagamentoById(1);

        // Assert
        assertEquals(Optional.of(expectedPagamento), actualPagamento);
    }

    @Test
    void testCreatePagamento() {
        // Arrange
        Pagamento pagamento = new Pagamento(1, "01/01/2022", "01/01/2022", 100.0, "Pix", 50.0, "Mensal", 50.0, 50.0);
        when(pagamentoRepository.save(pagamento)).thenReturn(pagamento);

        // Act
        Pagamento createdPagamento = pagamentoService.createPagamento(pagamento);

        // Assert
        assertEquals(pagamento, createdPagamento);
    }

    @Test
    void testUpdatePagamento() {
        // Arrange
        Pagamento pagamento = new Pagamento(1, "01/01/2022", "01/01/2022", 100.0, "Pix", 50.0, "Mensal", 50.0, 50.0);
        when(pagamentoRepository.updatePagamento("02/01/2022", 150.0, "Cartão", 0.0, "Débito", 100.0, 150.0, 1)).thenReturn(1);

        // Act
        Integer updatedRows = pagamentoService.updatePagamento(1, pagamento);

        // Assert
        assertEquals(0, updatedRows);
    }

    @Test
    void testDeletePagamento() {
        // Arrange
        when(pagamentoRepository.deletePagamentoById(1)).thenReturn(1);

        // Act
        Integer deletedRows = pagamentoService.deletePagamento(1);

        // Assert
        assertEquals(1, deletedRows);
    }

    @Test
    void testRegistrarPagamento() {
        // Arrange
        Pagamento pagamento = new Pagamento(1, "01/01/2022", "01/01/2022", 100.0, "Pix", 50.0, "Mensal", 50.0, 50.0);
        when(pagamentoRepository.findById(1)).thenReturn(Optional.of(pagamento));
        when(pagamentoRepository.updatePagamento("02/01/2022", 50.0, "Cartão", 0.0, "Débito", 100.0, 100.0, 1)).thenReturn(1);

        // Act
        int result = pagamentoService.registrarPagamento(1, "02/01/2022", 50.0);

        // Assert
        assertEquals(0, result);
    }
}