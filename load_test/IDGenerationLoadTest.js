import http from 'k6/http';
import { check } from 'k6';

const API_ENDPOINT = '/api/customers';
const LONGID_BASE_URL = __ENV.LONGID_BASE_URL ?? 'http://host.docker.internal:8080';
const HIBERNATEUUID_BASE_URL = __ENV.HIBERNATEUUID_BASE_URL ?? 'http://host.docker.internal:8081';
const JAVAUUID_BASE_URL = __ENV.JAVAUUID_BASE_URL ?? 'http://host.docker.internal:8082';
const NANOID_BASE_URL = __ENV.NANOID_BASE_URL ?? 'http://host.docker.internal:8083';

const RATE = __ENV.RATE ?? 1000;
const TIME_UNIT = __ENV.TIME_UNIT ?? 1;
const DURATION = __ENV.DURATION ?? 30;
const PRE_ALLOCATED_VUS = __ENV.PRE_ALLOCATED_VUS ?? 500;
const MAX_VUS = __ENV.MAX_VUS ?? 1000;

export let options = {
    scenarios: {},
};

if (__ENV.ENABLE_LONGID === 'true') {
    options.scenarios.longid = {
        executor: 'constant-arrival-rate',
        rate: RATE,
        timeUnit: `${TIME_UNIT}s`,
        duration: `${DURATION}s`,
        preAllocatedVUs: PRE_ALLOCATED_VUS,
        maxVUs: MAX_VUS,
        exec: 'longidTest',
    };
}

if (__ENV.ENABLE_HIBERNATEUUID === 'true') {
    options.scenarios.hibernateuuid = {
        executor: 'constant-arrival-rate',
        rate: RATE,
        timeUnit: `${TIME_UNIT}s`,
        duration: `${DURATION}s`,
        preAllocatedVUs: PRE_ALLOCATED_VUS,
        maxVUs: MAX_VUS,
        exec: 'hibernateuuidTest',
    };
}

if (__ENV.ENABLE_JAVAUUID === 'true') {
    options.scenarios.javauuid = {
        executor: 'constant-arrival-rate',
        rate: RATE,
        timeUnit: `${TIME_UNIT}s`,
        duration: `${DURATION}s`,
        preAllocatedVUs: PRE_ALLOCATED_VUS,
        maxVUs: MAX_VUS,
        exec: 'javauuidTest',
    };
}

if (__ENV.ENABLE_NANOID === 'true') {
    options.scenarios.nanoid = {
        executor: 'constant-arrival-rate',
        rate: RATE,
        timeUnit: `${TIME_UNIT}s`,
        duration: `${DURATION}s`,
        preAllocatedVUs: PRE_ALLOCATED_VUS,
        maxVUs: MAX_VUS,
        exec: 'nanoidTest',
    };
}

export function longidTest() {
    let res = http.post(`${LONGID_BASE_URL}${API_ENDPOINT}`, JSON.stringify({ firstname: 'John', lastname: 'Doe' }), {
        headers: { 'Content-Type': 'application/json' },
    });
    check(res, { 'status is 200': (r) => r.status === 200 });
}

export function hibernateuuidTest() {
    let res = http.post(`${HIBERNATEUUID_BASE_URL}${API_ENDPOINT}`, JSON.stringify({ firstname: 'John', lastname: 'Doe' }), {
        headers: { 'Content-Type': 'application/json' },
    });
    check(res, { 'status is 200': (r) => r.status === 200 });
}

export function javauuidTest() {
    let res = http.post(`${JAVAUUID_BASE_URL}${API_ENDPOINT}`, JSON.stringify({ firstname: 'John', lastname: 'Doe' }), {
        headers: { 'Content-Type': 'application/json' },
    });
    check(res, { 'status is 200': (r) => r.status === 200 });
}

export function nanoidTest() {
    let res = http.post(`${NANOID_BASE_URL}${API_ENDPOINT}`, JSON.stringify({ firstname: 'John', lastname: 'Doe' }), {
        headers: { 'Content-Type': 'application/json' },
    });
    check(res, { 'status is 200': (r) => r.status === 200 });
}

