package pl.javastart.demoapp.choinka;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoinkaRepository extends JpaRepository<Choinka, Long> {
}
