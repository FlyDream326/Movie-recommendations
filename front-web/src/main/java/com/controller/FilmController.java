package  com.controller;


import com.domain.vo.FilmVo;
import com.domain.vo.PageVo;
import com.service.FilmService;
import com.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public ResponseResult filmList(@RequestParam(required = false) String filmName,
                                   @RequestParam(required = false) String year,
                                   @RequestParam("pageNum")Integer pageNum,
                                   @RequestParam("pageSize")Integer pageSize){
        //filmName year 若有数值则进行模糊查询，空则进行分页查询，pageNum、pageSize 分页查询（不能为空）
        //        true 正在上映，false 即将上映
        PageVo pageVo = filmService.filmList(filmName,year,pageNum,pageSize,"NULL");
       return ResponseResult.okResult(pageVo);
    }
    @GetMapping("/{id}")
    public ResponseResult getFilmById(@PathVariable("id") Long id){
        FilmVo filmVo = filmService.getFilmById(id);
        return ResponseResult.okResult(filmVo);
    }
    @GetMapping("/unShowingList")
    public ResponseResult unShowingList(@RequestParam(required = false) String filmName,
                                   @RequestParam(required = false) String year,
                                   @RequestParam("pageNum")Integer pageNum,
                                   @RequestParam("pageSize")Integer pageSize){
        //filmName year 若有数值则进行模糊查询，空则进行分页查询，pageNum、pageSize 分页查询（不能为空）
        //        true 正在上映，false 即将上映
        PageVo pageVo = filmService.filmList(filmName,year,pageNum,pageSize, "false");
        return ResponseResult.okResult(pageVo);
    }
    @GetMapping("/showingList")
    public ResponseResult showingList(@RequestParam(required = false) String filmName,
                                   @RequestParam(required = false) String year,
                                   @RequestParam("pageNum")Integer pageNum,
                                   @RequestParam("pageSize")Integer pageSize){
        //filmName year 若有数值则进行模糊查询，空则进行分页查询，pageNum、pageSize 分页查询（不能为空）
        //        true 正在上映，false 即将上映
        PageVo pageVo = filmService.filmList(filmName,year,pageNum,pageSize, "true");
        return ResponseResult.okResult(pageVo);
    }
    //TODO 根据category 进行分类查询


}

