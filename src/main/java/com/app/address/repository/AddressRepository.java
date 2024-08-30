package com.app.address.repository;

import com.app.address.entity.Address;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class AddressRepository implements MongoRepository<Address, String> {
  Optional<Address> findByCode(String code) {
    return null;
  }

  /**
   * @param entity 
   * @param <S>
   * @return
   */
  @Override
  public <S extends Address> S insert(S entity) {
    return null;
  }

  /**
   * @param entities 
   * @param <S>
   * @return
   */
  @Override
  public <S extends Address> List<S> insert(Iterable<S> entities) {
    return List.of();
  }

  /**
   * @param example 
   * @param <S>
   * @return
   */
  @Override
  public <S extends Address> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  /**
   * @param example 
   * @param <S>
   * @return
   */
  @Override
  public <S extends Address> List<S> findAll(Example<S> example) {
    return List.of();
  }

  /**
   * @param example 
   * @param sort
   * @param <S>
   * @return
   */
  @Override
  public <S extends Address> List<S> findAll(Example<S> example, Sort sort) {
    return List.of();
  }

  /**
   * @param example 
   * @param pageable
   * @param <S>
   * @return
   */
  @Override
  public <S extends Address> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  /**
   * @param example 
   * @param <S>
   * @return
   */
  @Override
  public <S extends Address> long count(Example<S> example) {
    return 0;
  }

  /**
   * @param example 
   * @param <S>
   * @return
   */
  @Override
  public <S extends Address> boolean exists(Example<S> example) {
    return false;
  }

  /**
   * @param example 
   * @param queryFunction
   * @param <S>
   * @param <R>
   * @return
   */
  @Override
  public <S extends Address, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }

  /**
   * @param entity 
   * @param <S>
   * @return
   */
  @Override
  public <S extends Address> S save(S entity) {
    return null;
  }

  /**
   * @param entities 
   * @param <S>
   * @return
   */
  @Override
  public <S extends Address> List<S> saveAll(Iterable<S> entities) {
    return List.of();
  }

  /**
   * @param s 
   * @return
   */
  @Override
  public Optional<Address> findById(String s) {
    return Optional.empty();
  }

  /**
   * @param s 
   * @return
   */
  @Override
  public boolean existsById(String s) {
    return false;
  }

  /**
   * @return 
   */
  @Override
  public List<Address> findAll() {
    return List.of();
  }

  /**
   * @param strings 
   * @return
   */
  @Override
  public List<Address> findAllById(Iterable<String> strings) {
    return List.of();
  }

  /**
   * @return 
   */
  @Override
  public long count() {
    return 0;
  }

  /**
   * @param s 
   */
  @Override
  public void deleteById(String s) {

  }

  /**
   * @param entity 
   */
  @Override
  public void delete(Address entity) {

  }

  /**
   * @param strings 
   */
  @Override
  public void deleteAllById(Iterable<? extends String> strings) {

  }

  /**
   * @param entities 
   */
  @Override
  public void deleteAll(Iterable<? extends Address> entities) {

  }

  /**
   * 
   */
  @Override
  public void deleteAll() {

  }

  /**
   * @param sort 
   * @return
   */
  @Override
  public List<Address> findAll(Sort sort) {
    return List.of();
  }

  /**
   * @param pageable 
   * @return
   */
  @Override
  public Page<Address> findAll(Pageable pageable) {
    return null;
  }
}
