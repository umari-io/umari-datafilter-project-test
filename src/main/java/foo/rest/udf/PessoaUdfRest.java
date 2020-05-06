package foo.rest.udf;

import foo.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umari.datafilter.core.Aggregable;
import umari.datafilter.core.UdfRequest;
import umari.datafilter.service.UdfTemplate;

@RequestMapping("/api/udf/pessoa")
@RestController
public class PessoaUdfRest {

    @Autowired
    private UdfTemplate udfTemplate;

    /**
     * Endpoint para requisições de filtragem para a entidade Pessoa.
     *
     * @param udfRequest
     * @param pageable
     * @return
     */
    @PostMapping
    public ResponseEntity<Page<?>> filter(@RequestBody UdfRequest udfRequest, Pageable pageable) {
        return ResponseEntity.ok(udfTemplate.filter(
                Pessoa.class,
                udfRequest.getFilterable(),
                pageable));
    }

    /**
     * Endpoint para requisições de agregação para a entidade Pessoa
     *
     * <code>
     * {
     * 	"aggregables" : [{
     * 		"selector": "id",
     * 		"operation": "count"
     *        }]
     * }
     * </code>
     *
     * @param udfRequest
     * @return
     */
    @PostMapping("/agg")
    public ResponseEntity<?> aggreate(@RequestBody UdfRequest udfRequest) {
        return ResponseEntity.ok(udfTemplate.aggregate(
                Pessoa.class,
                udfRequest.getFilterable(),
                udfRequest.getAggregables().toArray(new Aggregable[]{})));

    }
}
