package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    return CompletableFuture.supplyAsync(() -> {
      List<Ceo> ceo = ceos.filter(x-> Objects.equals(x.id, ceo_id));
      return ceo.toOption();
    });
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    return CompletableFuture.supplyAsync(() -> {
      List<Enterprise> entreprise = enterprises.filter(x-> Objects.equals(x.ceo_id, ceo_id));
      return entreprise.toOption();
    });
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    return CompletableFuture.supplyAsync(() -> Tuple.of(getCeoById(ceo_id).join(), getEnterpriseByCeoId(ceo_id).join()));
  }

}
