package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    /**
     * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려 */
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;      // 0, 1, 2... 키 값을 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);   // store 넣기 전에 아이디 값 세팅
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // null 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();     // 같은 거 하나라도 찾음
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // test를 위해 store 의 데이터를 지우는 함수
    public void clearStore() {
        store.clear();
    }
}
