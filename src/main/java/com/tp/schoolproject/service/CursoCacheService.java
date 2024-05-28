package com.tp.schoolproject.service;


import com.tp.schoolproject.entity.Curso;
import com.tp.schoolproject.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CursoCacheService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private CursoRepository cursoRepository;

    private static final String CURSO_CACHE_KEY = "CURSO";

    public Curso findById(Long id) {
        String key = CURSO_CACHE_KEY + ":" + id;
        Curso curso = (Curso) redisTemplate.opsForValue().get(key);
        if (curso == null) {
            curso = cursoRepository.findById(id).orElse(null);
            if (curso != null) {
                redisTemplate.opsForValue().set(key, curso, 10, TimeUnit.MINUTES);
            }
        }
        return curso;
    }

    public Curso save(Curso curso) {
        curso = cursoRepository.save(curso);
        String key = CURSO_CACHE_KEY + ":" + curso.getId();
        redisTemplate.opsForValue().set(key, curso, 10, TimeUnit.MINUTES);
        return curso;
    }

    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
        String key = CURSO_CACHE_KEY + ":" + id;
        redisTemplate.delete(key);
    }
}