package  com.controller;


import com.service.FilmService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * (Film)表控制层
 *
 * @author makejava
 * @since 2023-04-05 15:39:18
 */
@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/list")
    public ResponseResult filmList(){
        Long id = 6166L;
       return ResponseResult.okResult(filmService.getById(id));
    }

}

