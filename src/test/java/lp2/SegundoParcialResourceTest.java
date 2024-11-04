package lp2;

import lp2.resources.SegundoParcialResource;
import lp2.services.SegundoParcialService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@QuarkusTest
public class SegundoParcialResourceTest {
  @InjectMocks
  SegundoParcialResource segundoParcialResource;

  @Mock
  SegundoParcialService segundoParcialService;

  public SegundoParcialResourceTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testListaVacia() {
    Response response = segundoParcialResource.procesarLista(Collections.emptyList());
    assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    assertEquals(Map.of("error", "El listado de palabras no puede estar vacía ni ser null."), response.getEntity());
  }

  @Test
  public void testListaNula() {
    Response response = segundoParcialResource.procesarLista(null);
    assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    assertEquals(Map.of("error", "El listado de palabras no puede estar vacía ni ser null."), response.getEntity());
  }

  @Test
  public void testListaConDatosInvalidos() {
    Response response = segundoParcialResource.procesarLista(Arrays.asList(1, 2, 3));
    assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    assertEquals(Map.of("error", "La lista debe contener solo palabras."), response.getEntity());
  }

  @Test
  public void testListaConDatosValidos() {
    List<Object> inputList = Arrays.asList("radar", "palabra", "level");
    Map<String, Object> serviceResponse = new HashMap<>();
    serviceResponse.put("Total Palindromos", 2);
    serviceResponse.put("Listado Palindromos", Arrays.asList("radar", "level"));

    when(segundoParcialService.procesarListadoPalabras(anyList())).thenReturn(serviceResponse);

    Response response = segundoParcialResource.procesarLista(inputList);

    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    assertEquals(serviceResponse, response.getEntity());
    verify(segundoParcialService, times(1)).procesarListadoPalabras(List.of("radar", "palabra", "level"));
  }

  @Test
  public void testListaConDatosValidosPeroSinPalindromos() {
    List<Object> inputList = Arrays.asList("palabra", "casa", "mesa");
    Map<String, Object> serviceResponse = new HashMap<>();
    serviceResponse.put("Total Palindromos", 0);
    serviceResponse.put("Listado Palindromos", Collections.emptyList());

    when(segundoParcialService.procesarListadoPalabras(anyList())).thenReturn(serviceResponse);

    Response response = segundoParcialResource.procesarLista(inputList);

    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    assertEquals(serviceResponse, response.getEntity());
    verify(segundoParcialService, times(1)).procesarListadoPalabras(List.of("palabra", "casa", "mesa"));
  }

  @Test
  public void testListaConError() {
    List<Object> inputList = Arrays.asList("palabra1", "palabra2");

    when(segundoParcialService.procesarListadoPalabras(anyList())).thenThrow(new RuntimeException());

    Response response = segundoParcialResource.procesarLista(inputList);

    assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    assertEquals("Ocurrió un error.", response.getEntity());
  }
}