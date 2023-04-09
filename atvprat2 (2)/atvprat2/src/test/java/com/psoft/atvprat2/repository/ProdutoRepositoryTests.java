package com.psoft.atvprat2.repository;

@SpringBootTest
@DisplayName("Testes do repositório de Produtos")
public class ProdutoRepositoryTest {

    @Autowired
    ProdutoRepository driver;

    Produto produto;

    @BeforeEach
    void setup() {
        produto = TestUtils.criarProduto(10L, "Produto Dez", "Fabricante Dez", "1230910293312", 100.0);
    }

    @Test
    @DisplayName("Quando criar um novo produto com dados válidos")
    void testQuandoCriarProduto() {
        Produto resultado = driver.save(produto);

        assertNotNull(resultado);
        assertEquals("Produto Dez", resultado.getNome());
        assertEquals("Fabricante Dez", resultado.getFabricante());
        assertEquals("1938298123", resultado.getCodigoBarra());
        assertEquals(100.00, resultado.getPreco());
    }
}
